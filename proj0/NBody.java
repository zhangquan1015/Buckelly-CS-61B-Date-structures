public class NBody{
    static int N;//the number of planets.
    static double R;//the radius of the universe

    public static double readRadius(String file){
        In in=new In(file);
        N=in.readInt();
        R=in.readDouble();
        return R;
    }

    public static Body[] readBodies(String file){
        In in=new In(file);
        N=in.readInt();
        R=in.readDouble();
        Body[] b1=new Body[N];
        for(int i=0;i<N;i++){
            double xP=in.readDouble();
            double yP=in.readDouble();
            double xV=in.readDouble();
            double yV=in.readDouble();
            double m=in.readDouble();
            String img=in.readString();
            Body b2=new Body(xP,yP,xV,yV,m,img);
            b1[i]=new Body(b2);
        }
        return b1;
    }
}
