class Codec:
    def encode(self, strs: [str]) -> str:
        """Encodes a list of strings to a single string.
        """
        string = ""
        for s in strs:
            s = s.replace("#", "##")
            string += f"{s} # "
        return string

    def decode(self, s: str) -> [str]:
        """Decodes a single string to a list of strings.
        """
        strs = s.split(" # ")
        for i in range(len(strs)):
            strs[i] = strs[i].replace("##", "#")
        return strs[:-1]


# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.decode(codec.encode(strs))
