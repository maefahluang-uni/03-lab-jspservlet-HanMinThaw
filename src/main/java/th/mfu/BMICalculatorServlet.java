package th.mfu;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//TODO: add webservlet to "/calbmi"
@WebServlet(urlPatterns = "/calbmi")
public class BMICalculatorServlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO: get parameter from request: "weight" and "height"
        String weight = request.getParameter("weight");
        String height = request.getParameter("height");

        double bmiWeight = Double.parseDouble(weight);
        double bmiHeight = Double.parseDouble(height);

        
        //TODO: calculate bmi
        double bmi = Math.round(bmiWeight / (bmiHeight * bmiHeight));
        
        
        //TODO: determine the built from BMI
        String ans;
        if (bmi < 18.5){
            ans = "underweight";
        } else if (bmi >= 18.5 && bmi < 25){
            ans = "normal";
        } else if (bmi >= 25 && bmi < 30){
            ans = "overweight";
        } else if (bmi >= 30 && bmi < 35){
            ans = "obese";
        } else {
            ans = "extemely obese";
        }
        //TODO: add bmi and built to the request's attribute
        request.setAttribute("bmi", bmi);
        request.setAttribute("ans", ans);

        //TODO: forward to jsp
           request.getRequestDispatcher("/bmi_result.jsp").forward(request, response);
    }
    
}
