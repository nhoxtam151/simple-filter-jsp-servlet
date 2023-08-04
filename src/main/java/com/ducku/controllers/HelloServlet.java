package com.ducku.controllers;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

  private static Map<String, String> users = new HashMap<>();


  //fake users
  public HelloServlet() {
    users.put("it's me", "123");
    users.put("prettyboy", "456");
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    Optional<String> username = Optional.ofNullable(request.getParameter("name"));
    Optional<String> password = Optional.ofNullable(request.getParameter("password"));

    if (username.isEmpty() || password.isEmpty()) {
      response.sendRedirect("index.jsp");
    }

    if (checkUserCredentials(username.get(), password.get(), users)) {
      HttpSession session = request.getSession();
      session.setAttribute("username", username.get());

      response.sendRedirect("welcome");
    } else {
      response.sendRedirect("/myapp");
    }
  }

  public boolean checkUserCredentials(String username, String password, Map<String, String> users) {
    for (Map.Entry<String, String> entry : users.entrySet()) {
      if (entry.getKey().equals(username) && entry.getValue().equals(password)) {
        return true;
      }
    }
    return false;
  }
}
