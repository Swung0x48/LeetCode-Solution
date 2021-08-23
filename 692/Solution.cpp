class Solution {
public:
    vector<string> topKFrequent(vector<string>& words, int k) {
        unordered_map<string, int> map;
        for (auto& i: words) {
            map[i] += 1;
        }

        vector<std::pair<int, string>> vec;
        vec.reserve(map.size());
        for (auto& [key, value]: map) {
            vec.emplace_back(value, key);
        }

        std::partial_sort(vec.begin(), vec.begin() + k, vec.end(), [](const std::pair<int, string>& a, const std::pair<int, string>& b) {
            if (a.first == b.first)
                return a.second.compare(b.second) < 0;
            return a.first > b.first;
        });

        for (auto& [key, value]: vec) {
            cout << key << ' ' << value << '\n';
        }

        vector<string> ret;
        ret.reserve(k);
        for (int i = 0; i < k; ++i) {
            ret.emplace_back(vec[i].second);
        }
        return ret;
    }
};