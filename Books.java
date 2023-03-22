public class Books {
    private static ArrayList<Books> allBooks = new ArrayList<>();

    private String name;

    private String author;

    private String genre;

    private int year;


    public Books(String name, String author, String genre, int year) {
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.year = year;
    }

    public static ArrayList<Books> getAllBooks() {
        return allBooks;
    }

    public static void setAllBooks(ArrayList<Books> allBooks) {
        Books.allBooks = allBooks;
    }

    public String getName() {return name;}

    public void setBrand(String name) {this.name = name;}

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {return year;}

    public void setYear(int year) {this.year = year;}

    @Override
    }
    public static void signOut() {
        Scanner sc = null;
        try {
            File text = new File("Books");
            sc = new Scanner(text);
            String line;
            while (sc.hasNextLine()) {
                line = sc.nextLine();
                System.out.println(line);
                Scanner lineScanner = new Scanner(line);
                lineScanner.useDelimiter("\t");
                String name = lineScanner.next();
                String author = lineScanner.next();
                String genre = lineScanner.next();
                int year = lineScanner.nextInt();
                new Books(name,author,genre,year);

                while(lineScanner.hasNext()) {
                    String chunkoData = lineScanner.next();
                    System.out.println(chunkoData);
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (sc != null) sc.close();
        }
    }
}
