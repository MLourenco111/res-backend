package com.fiap.res;

public enum StringTransform {

    SAFE_LOWER {
        @Override
        public String apply(String str) {
            return str == null ? null : str.toLowerCase();
        }
    },

    SAFE_UPPER {
        @Override
        public String apply(String str) {
            return str == null ? null : str.toUpperCase();
        }
    },

    UPPER_TRIM {
        @Override
        public String apply(String str) {
            if (str == null) return null;
            return str.toUpperCase().trim();
        }
    },

    CAPITALIZE_WORDS {
        @Override
        public String apply(String str) {
            if (str == null || str.isBlank()) {
                return str;
            }
            String[] words = str.trim().toLowerCase().split("\\s+");
            StringBuilder sb = new StringBuilder();
            for (String word : words) {
                if (!word.isEmpty()) {
                    sb.append(Character.toUpperCase(word.charAt(0)));
                    if (word.length() > 1) {
                        sb.append(word.substring(1));
                    }
                    sb.append(" ");
                }
            }
            return sb.toString().trim();
        }
    },

    NORMALIZE{
        @Override
        public String apply(String str){
            if(str == null || str.isBlank()) return null;
            return str.replaceAll("[^0-9A-Za-z]", "").toUpperCase().trim();
        }
    },

    IS_EMPTY {
        @Override
        public boolean test(String str) {
            return str == null || str.isBlank();
        }

        @Override
        public String apply(String str) {
            throw new UnsupportedOperationException("IS_EMPTY does not transform strings. Use test().");
        }
    };

    public abstract String apply(String str);

    public boolean test(String str) {
        throw new UnsupportedOperationException("This operation does not support testing.");
    }
}

