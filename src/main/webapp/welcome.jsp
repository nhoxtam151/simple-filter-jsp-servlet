<html lang="en">
  <head>
    <meta charset="UTF-8">
    <title>Welcome Page</title>
  </head>
  <body>

    <%

      String username = session.getAttribute("username").toString();
      out.println("<h1>Welcome back, " + username + "</h1>");
    %>
    <br>
    <a href="videos">Video Here</a>
   <a href="logout"> <input type="submit" value="Logout"> </a>
  </body>
</html>