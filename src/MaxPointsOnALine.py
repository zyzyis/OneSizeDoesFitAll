class Solution:
    def getParam(self, p0, p1):  # get slope , intercept
        if p0.x == p1.x:
            return (0.0, p0.x, True)
        k = (float)(p1.y - p0.y) / (p1.x - p0.x);
        return (k, p0.y - k * p0.x, False)
        
    def maxPoints(self, points):
        pmap = {} # hash for parameter
        dups = {} # hash for duplicates
        maxCount = len(points) if len(points) < 2 else 2
        for p in points: # deduplicate points
            if not p in dups:
                dups[p] = 0
            dups[p] += 1
        points = dups.keys()
        
        for i in range(len(points)):
            for j in range(i + 1, len(points)):
                param = self.getParam(points[i], points[j])
                if not pmap.has_key(param):
                    pmap[param] = set()
                pmap[param].add(i)
                pmap[param].add(j)
        
        for plist in pmap.values():
            count = 0
            for y in plist:
                count += dups[points[y]]
            maxCount = max(maxCount, count)
        return maxCount