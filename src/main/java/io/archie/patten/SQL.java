package io.archie.patten;

public class SQL {

    public static void main(String[] args) {
        String selectSql = SQL.builder(SQLType.SELECT)
                .columns("name", "age")
                .table("user")
                .where("id > 10")
                .build();

        System.out.println(selectSql);
    }

    public static Builder builder(SQLType type) {
        return new Builder(type);
    }

    public static final class Builder {

        private final SQLType type;

        private String[] columns;

        private String table;

        private String where;

        public Builder(SQLType type) {
            this.type = type;
        }

        public Builder columns(String... columns) {
            this.columns = columns;
            return this;
        }

        public Builder table(String table) {
            this.table = table;
            return this;
        }

        public Builder where(String where) {
            this.where = where;
            return this;
        }

        public String build() {
            return switch (type) {
                case INSERT -> "";
                case DELETE -> "";
                case UPDATE -> "";
                case SELECT -> "SELECT " + String.join(", ", columns) + " FROM " + table + " WHERE " + where;
            };
        }


    }

    public enum SQLType {
        INSERT,
        DELETE,
        UPDATE,
        SELECT
    }

}
