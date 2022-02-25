public  class Planet{
    public double xxPos;//Its current x position
    public double yyPos;//Its current y position
    public double xxVel;//Its current velocity in the x direction
    public double yyVel;//Its current velocity in the y direction
    public double mass;//Its mass
    public String imgFileName;//The name of the file that corresponds to the image that depicts the body

    public Planet(double xP,double yP,double xV,double yV,double m,String img){
        this.xxPos=xP;
        this.yyPos=yP;
        this.xxVel=xV;
        this.yyVel=yV;
        this.mass=m;
        this.imgFileName=img;
    }   
    public Planet(Planet b){
        this.xxPos=b.xxPos;
        this.yyPos=b.yyPos;
        this.xxVel=b.xxVel;
        this.yyVel=b.yyVel;
        this.mass=b.mass;
        this.imgFileName=b.imgFileName;
    }
    
    public double xxDis;//The distance between Planeta and Planetb in x
    public double yyDis;//The distance between Planeta and Planetb in y
    
    public double calcDistance(Planet b){
        xxDis=b.xxPos-this.xxPos;
        yyDis=b.yyPos-this.yyPos;
        return Math.sqrt(Math.pow(xxDis,2)+Math.pow(yyDis,2));
    }
    
    public static double G=6.67e-11;
    public double calcForceExertedBy(Planet b){
        return G*this.mass*b.mass/Math.pow(this.calcDistance(b),2);
    }

    public double calcForceExertedByX(Planet b){
        xxDis=b.xxPos-this.xxPos;
        return this.calcForceExertedBy(b)*xxDis/this.calcDistance(b);
    }

    public double calcForceExertedByY(Planet b){
        yyDis=b.yyPos-this.yyPos;
        return this.calcForceExertedBy(b)*yyDis/this.calcDistance(b);
    }

    public double calcNetForceExertedByX(Planet[] allPlanets){
        int len=allPlanets.length;
        double NetForceX=0;
        for(int i=0;i<len;i++){
            if(this.equals(allPlanets[i]))
                continue;
            NetForceX+=this.calcForceExertedByX(allPlanets[i]);
        }
        return NetForceX;
    }

    public double calcNetForceExertedByY(Planet[] allPlanets){
        int len=allPlanets.length;
        double NetForceY=0;
        for(int i=0;i<len;i++){
            if(this.equals(allPlanets[i]))
                continue;
            NetForceY+=this.calcForceExertedByY(allPlanets[i]);
        }
        return NetForceY;
    }

    public void update(double dt,double fX,double fY){
        double xxAcc=fX/this.mass;
        double yyAcc=fY/this.mass;
        this.xxVel+=xxAcc*dt;
        this.yyVel+=yyAcc*dt;
        this.xxPos+=this.xxVel*dt;
        this.yyPos+=this.yyVel*dt;
    }
    //Drawing One Planet
    public void draw(){
        String path="images/";//the Relative Path
        path+=this.imgFileName;
        StdDraw.picture(this.xxPos,this.yyPos,path);
    }
}
