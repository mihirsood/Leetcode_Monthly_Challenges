class RandomizedSet {
    //this map monitors if a values is present or not
    //if present it also gives its index
    unordered_map<int, int> cache;

    //here we store the values
    vector<int> values;

    //Note : map is required for O(1) insertion and deletion
    //       vector is required for O(1) random selection

    int n = 0;        //this keeps the size of vector
public:
    RandomizedSet() {}

    bool insert(int val) {
      if(cache.count(val))
          return false;

      cache[val] = n++;
      values.push_back(val);
      return true;
    }

    bool remove(int val) {
       if(!cache.count(val))
          return false;


        //To remove an element we get it's index from cache map,
        //place last element of vector at this index
        //also update index of last element in cache map
        //and remove the last element in O(1) time
        //Also note : if we would have used  erase function for vector, it would have cost O(n)

        int ind = cache[val];
        int last_element = values.back();
        values[ind] = last_element;
        cache[last_element] = ind;
        values.pop_back();
        n--;

        cache.erase(val);
        return true;
    }

    int getRandom() {
     return values[rand()%n];
    }
};
