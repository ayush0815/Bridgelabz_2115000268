class Movie {
    String title;
    String director;
    int releaseYear;
    double rating;
    Movie next;
    Movie prev;

    public Movie(String title, String director, int releaseYear, double rating) {
        this.title = title;
        this.director = director;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

class MovieDoublyLinkedList {
    private Movie head;
    private Movie tail;

    // Add a movie at the beginning
    public void addAtBeginning(String title, String director, int releaseYear, double rating) {
        Movie newMovie = new Movie(title, director, releaseYear, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    // Add a movie at the end
    public void addAtEnd(String title, String director, int releaseYear, double rating) {
        Movie newMovie = new Movie(title, director, releaseYear, rating);
        if (tail == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    // Add a movie at a specific position (1-based index)
    public void addAtPosition(String title, String director, int releaseYear, double rating, int position) {
        if (position < 1) {
            System.out.println("Invalid position!");
            return;
        }

        Movie newMovie = new Movie(title, director, releaseYear, rating);
        if (position == 1) {
            addAtBeginning(title, director, releaseYear, rating);
            return;
        }

        Movie temp = head;
        for (int i = 1; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }

        if (temp == null || temp.next == null) {
            addAtEnd(title, director, releaseYear, rating);
            return;
        }

        newMovie.next = temp.next;
        newMovie.prev = temp;
        temp.next.prev = newMovie;
        temp.next = newMovie;
    }

    // Remove a movie by title
    public void removeByTitle(String title) {
        if (head == null) {
            System.out.println("No movies found!");
            return;
        }

        Movie temp = head;
        while (temp != null && !temp.title.equalsIgnoreCase(title)) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Movie not found!");
            return;
        }

        if (temp == head) {
            head = head.next;
            if (head != null) head.prev = null;
        } else if (temp == tail) {
            tail = tail.prev;
            if (tail != null) tail.next = null;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
    }

    // Search for movies by director
    public void searchByDirector(String director) {
        Movie temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director)) {
                System.out.println("Movie: " + temp.title + " | Year: " + temp.releaseYear + " | Rating: " + temp.rating);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("No movies found by director: " + director);
        }
    }

    // Search for movies by rating
    public void searchByRating(double rating) {
        Movie temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.rating == rating) {
                System.out.println("Movie: " + temp.title + " | Director: " + temp.director + " | Year: " + temp.releaseYear);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("No movies found with rating: " + rating);
        }
    }

    // Display all movies (forward traversal)
    public void displayForward() {
        if (head == null) {
            System.out.println("No movies available.");
            return;
        }

        Movie temp = head;
        System.out.println("Movies List (Forward Order):");
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.director + " | " + temp.releaseYear + " | Rating: " + temp.rating);
            temp = temp.next;
        }
    }

    // Display all movies (reverse traversal)
    public void displayReverse() {
        if (tail == null) {
            System.out.println("No movies available.");
            return;
        }

        Movie temp = tail;
        System.out.println("Movies List (Reverse Order):");
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.director + " | " + temp.releaseYear + " | Rating: " + temp.rating);
            temp = temp.prev;
        }
    }

    // Update movie rating by title
    public void updateRating(String title, double newRating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                System.out.println("Rating updated successfully for: " + title);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found!");
    }
}
public class MovieManagementSystem {
    public static void main(String[] args) {
        MovieDoublyLinkedList movieList = new MovieDoublyLinkedList();

        // Adding movies
        movieList.addAtEnd("Inception", "Christopher Nolan", 2010, 8.8);
        movieList.addAtEnd("Dunkirk", "Christopher Nolan", 2014, 9.2);
        movieList.addAtBeginning("Interstellar", "Christopher Nolan", 2014, 9.6);
        movieList.addAtPosition("The Matrix", "Wachowskis", 1999, 8.7, 2);

        // Display movies
        movieList.displayForward();
        movieList.displayReverse();

        // Searching for a movie
        System.out.println("\nSearching movies by director Christopher Nolan:");
        movieList.searchByDirector("Christopher Nolan");

        System.out.println("\nSearching movies with rating 8.7:");
        movieList.searchByRating(8.7);

        // Updating rating
        movieList.updateRating("Dunkirk", 9.3);
        movieList.displayForward();

        // Deleting a movie
        movieList.removeByTitle("The Matrix");
        movieList.displayForward();
    }
}
