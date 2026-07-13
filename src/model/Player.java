package model;

public class Player {
    
    private String id;
    private String username;
    private int currentPos;
    private boolean hasWon;

    

    public Player(String id, String username, int currentPos, boolean hasWon) {
        this.id = id;
        this.username = username;
        this.currentPos = currentPos;
        this.hasWon = hasWon;
    }
    
    public int play(Dice dice){
        
        return dice.roll();
        
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public int getCurrentPos() {
        return currentPos;
    }
    public void setCurrentPos(int currentPos) {
        this.currentPos = currentPos;
    }
    public boolean isHasWon() {
        return hasWon;
    }
    public void setHasWon(boolean hasWon) {
        this.hasWon = hasWon;
    }

    
    
    
}
