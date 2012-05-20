public class TestChessMoves {
    public static void main (String args[]) {
        System.out.println("Test Chess Moves");
        
        FullNotation fullNotation = new FullNotation("h5", "h7", "Queen", "capture", "mate", "");
        ShortNotation shortNotation = new ShortNotation("h5", "h7", "", "");

        System.out.println(fullNotation.makeNotation());
        System.out.println(shortNotation.makeNotation());
    }
}

