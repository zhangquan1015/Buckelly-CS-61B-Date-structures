public class NBody{
    static int N;//the number of planets.
    static double R;//the radius of the universe

    // Given a file name as a String, it should return a double corresponding to the radius of the universe in that file
    public static double readRadius(String file){
        In in=new In(file);
        N=in.readInt();
        R=in.readDouble();
        return R;
    }

    //  Given a file name, it should return an array of Bodys corresponding to the bodies in the file
    public static Body[] readBodies(String file){
        In in=new In(file);
        N=in.readInt();
        in.readDouble();
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

    //Drawing the Initial Universe State
    public static void main(String[] args){
        double T=Double.parseDouble(args[0]);
        double dt=Double.parseDouble(args[1]);
        String filename=args[2];
        R=NBody.readRadius(filename);
        Body[] b=NBody.readBodies(filename);
        //Drawing the Background
        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(-R,R);
        String path="images/starfield.jpg";
        StdDraw.picture(0,0,path);
        //Drawing More than One Body
        for(int i=0;i<N;i++){
            b[i].draw();
        }
        StdDraw.show();
        StdDraw.pause(2000);
    }
}
