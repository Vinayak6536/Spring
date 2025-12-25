<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<html>
<body>

<form action="<%= request.getContextPath() %>/update" method="post">
<pre>
<input type="number" name="medicineId" value="${medicine.getMedicineId()}" hidden/>
medicineName:<input type="text" name="medicineName" value="${medicine.getMedicineName()}"/>
medicinePrice:<input type="text" name="medicinePrice" value="${medicine.getMedicinePrice()}"/>
MG:<input type="text" name="mg" value="${medicine.getMg()}"/>
Combination:<input type="text" name="combination" value="${medicine.getCombination()}"/>
ExpiryDate:<input type="text" name="expiryDate" value="${medicine.getExpiryDate()}"/>
<input type="submit" value="update">
</pre>
</form>
</body>
</html>
