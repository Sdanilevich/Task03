package by.htp.catalognews.entity.criteria;

public final class SearchCriteria {
    public static enum CriteriaNews{
        CATEGORY{{
                this.nameField="category";
                this.type = Type.STRING;}
            },
        COUNTRY{{
             this.nameField="country";
             this.type = Type.STRING;
            }
        },
        NAME{{
             this.nameField="name";
             this.type = Type.STRING;
            }
        },
        NEWS_BODY{{
            this.nameField="newsBody";
            this.type = Type.STRING;}
        },
        PROVIDER_NAME{{
            this.nameField="providerName";
            this.type = Type.STRING;}
        },
        PROVIDER_AUTHORS{{
            this.nameField="providerAuthors";
            this.type = Type.LIST;}
        };
        public String nameField;
        public Type type;
    }
}
