import java.util

public class BMIModel
{
    private double weight;
    private double height;

    public BMIModel(String w, String h)
    {
        this.weight = Double.parseDouble(w);
        this.height = Double.parseDouble(h);
    }

    public String getBMI()
    {
        double index = this.weight/(this.height * this.height);
        String result = String.format("%.1f", index);
        return result;
    }

    public String toPound(){
        long weightP = Math.round(this.weight / 0.454);
        String result = "" + weightP;
        return result;
    }

    public String toFeetInch(){
        String h = Utility.m2FtInch(this.height);
        return h;
    }

    public static void main(String[] args)
    {
        BMIModel myModel = new BMIModel("77", "1.8");
        System.out.println(myModel.getBMI());
        System.out.println(myModel.toPound());
        System.out.println(myModel.toFeetInch());

        myModel = new BMIModel("45", "1.35");
        System.out.println(myModel.getBMI());

        myModel = new BMIModel("80", "1.2");
        System.out.println(myModel.getBMI());
    }

}


