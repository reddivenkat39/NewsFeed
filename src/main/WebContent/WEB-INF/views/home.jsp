<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Home!</title>
</head>
<body>
<h2>SearchOrPost</h2>
<form:form method="POST" action="/PostMe/searchLink">
<form:label path="search">Search</form:label>
<form:input path="search"/>
<input type="submit" value="Search"/>
</form:form>
<br>
<form:form method="POST" action="/PostMe/postLink">
<form:label path="post">Post</form:label>
<form:input path="post"/>
<input type="submit" value="post"/>
</form:form>
<br>
<br>
<form:form method="POST" action="/PostMe/NewsFeed">
<input type="submit" value="NewsFeed"/>
</form:form>
</body>
</html>