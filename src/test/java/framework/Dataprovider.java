package framework;

import org.testng.annotations.DataProvider;

public class Dataprovider {

    @DataProvider(name = "userdata")
    public Object[][] allUsers() {
        return new Object[][]{
                {"peta@example.org", "Peta", "Francis", 34},
                {"george@example.com", "Goerge", "Pearson", 45},
                {"faye@example.com", "Faye", "Thames", 42},
                {"sandeep@ertedd.test", "Sandeep", "Midha", 23},
                {"rory@domain.test", "Rory", "Winter", 41},
                {"jenny@another.test", "Jenny", "Wu", 53},
                {"m@thisisa.test", "Mark", "Ehrenreich", 38},
                {"cora@domain.test", "Cora", "Engel", 28},
                {"dan@oprqu.test", "Dan", "Ankemah", 31},
                {"jorge@op3ueopup.test", "Jorge", "Georgiannakis", 29},
                {"pooja@example.org", "Pooja", "Reddy", 27},
                {"enzo@ooooe.test", "Enzo", "Fumagelli", 52},
                {"natashia@eopjpo.test", "Natasha", "Pham", 35},
                {"sandeep@ertedd.test", "Sandeep", "Midha", 23},
                {"m@thisisa.test", "Miranda", "Croft", 27},
                {"jorge@op3ueopup.test", "Jorge", "Georgiannakis", 29},
                {"roshni@pojopjw.test", "Roshni", "Khalid", 37},
                {"julio@opjpoj.test", "Julio", "Galinder", 35},
                {"elida@opjopj.test", "Elida", "Moura", 61},
                {"chris@ohoph.test", "Chris", "Ingilby", 31},
                {"emily@sopjs.test", "Emily", "Crobak", 28},
                {"maryam@eopjp.test", "Maryam", "Kapur", 41}
        };
    }

    @DataProvider(name = "updateDetails")
    public Object[][] updateUsers() {
        return new Object[][]{
                {"george@example.com", "first_name", "Goerge", "Jorge"},
                {"cora@domain.test", "age", 28, 38},
                {"dan@oprqu.test", "last_name", "Ankemah", "Ankomah"}
        };
    }

    @DataProvider(name = "searchCriteria")
    public Object[][] searchResults() {
        return new Object[][]{
                {20, 50, "steve@austin.com"},
                {50, 60, "jenny@another.test,enzo@ooooe.test"}
        };
    }

    public Object[] getUserDetailsByEmail(String email) {
        Object[][] getAllUsers = allUsers();
        for (int i = 0; i < getAllUsers.length; i++) {
            if (getAllUsers[i][0].equals(email)) {
                return getAllUsers[i];
            }
        }
        return null;
    }

}
