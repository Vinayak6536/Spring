<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<html>
<body>
    <form action="search" method="get">
        <input
            type="search"
            name="query"
            placeholder="Search here..."
            required
        >
        <button type="submit">Search</button>
    </form>

<pre>
MedicineId: ${medicine.getMedicineId()}
MedicineName: ${medicine.getMedicineName()}
MedicinePrice: ${medicine.getMedicinePrice()}
Mg: ${medicine.getMg()}
Combination: ${medicine.getCombination()}
Expiry Date: ${medicine.getExpiryDate()}
</pre>
</body>
</html>