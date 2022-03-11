public class OffByN implements CharacterComparator{
    private int off;

    @Override
    public boolean equalChars(char x, char y) {
        if(Math.abs(x-y) == off)
            return true;
        else
            return false;
    }


    public OffByN(int N){
        off = N;
    }

}
