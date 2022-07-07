from collections import defaultdict
from collections import OrderedDict


class LFUCache:

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.minFreq = 1
        self.freqKey = defaultdict(OrderedDict)
        self.keyFreq = defaultdict()

    def get(self, key: int) -> int:
        if key in self.keyFreq:
            freq = self.keyFreq[key]
            val = self.freqKey[freq][key]
            del self.freqKey[freq][key]
            if not self.freqKey[freq]:
                if freq == self.minFreq:
                    self.minFreq += 1
                del self.freqKey[freq]
            self.freqKey[freq+1][key] = val
            self.keyFreq[key] += 1
            return val
        return -1

    def put(self, key: int, value: int) -> None:
        if self.capacity == 0:
            return
        if key in self.keyFreq:
            self.freqKey[self.keyFreq[key]][key] = value
            self.get(key)
        else:
            if len(self.keyFreq) == self.capacity:
                delkey, delval = self.freqKey[self.minFreq].popitem(last=False)
                del self.keyFreq[delkey]
            self.keyFreq[key] = 1
            self.freqKey[1][key] = value
            self.minFreq = 1


# Your LFUCache object will be instantiated and called as such:
# obj = LFUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)
