class Solution {
    public boolean isNumber(String s) {

        boolean numberSeen = false;
        boolean dotSeen = false;
        boolean eSeen = false;
        boolean numberAfterE = true;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                numberSeen = true;

                if (eSeen) {
                    numberAfterE = true;
                }
            }

            else if (ch == '+' || ch == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e'
                           && s.charAt(i - 1) != 'E') {
                    return false;
                }
            }

            else if (ch == '.') {
                
                if (dotSeen || eSeen) {
                    return false;
                }
                dotSeen = true;
            }

            else if (ch == 'e' || ch == 'E') {
                if (eSeen || !numberSeen) {
                    return false;
                }

                eSeen = true;
                numberAfterE = false;
            }

            else {
                return false;
            }
        }

        return numberSeen && numberAfterE;
    }
}