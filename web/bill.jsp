<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bill</title>
<style>
.sbor{
  border-top-style : dashed;
  border-width : 1px;
  margin : 20px;
}
.bill{
  text-align : center;
  height : 50%;
  width : 30%;
  background-color : yellow;
  border : .1px solid black;
  outline : 25px solid yellow;
  font-family : arial;
  margin : 10% 30%;
}
.button{
  text-align : center;
  display : inline-block;
  padding : 5px;
  background-color : lightgrey;
  color : blue;
  margin : 10px;
  text-decoration : none;
}
.button:hover{
  background-color : green;
  color : white;
  transition-duration: .5s;
  box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24), 0 17px 50px 0 rgba(0,0,0,0.19);
}
</style>
</head>
<body style="background-color:powderblue;">
<a class="button" style="float:right;" href="logout">logout</a>
<div class="bill">
<h1 style="color:red;">BILL</h1><hr>
<pre>
Main Ammount :  <%=request.getParameter("bill") %><br>
CGST :         + 9%<br>
IGST :         + 9%<br><hr class="sbor">
Total Ammount : <%=Integer.parseInt(request.getParameter("bill"))*1.18 %>
</pre>
<a class="button" href="index.html">Check Out</a>
</div>

</body>
</html>