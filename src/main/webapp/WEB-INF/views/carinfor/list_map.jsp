<%@ page import="java.util.HashMap, java.util.ArrayList, com.yojulab.study_springboot.utils.Paginations" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bootstrap 5 Template</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css">
</head>

<body>
    <!-- Menu -->
    <%@ include file="/WEB-INF/views/commons/header.jsp" %>

    <% HashMap params=(HashMap)request.getAttribute("params"); String searchStr=(String)params.getOrDefault("search", ""
        ); HashMap result=(HashMap)request.getAttribute("result"); %>
        <!-- Main Content -->
        <form action="" method="">
            <div class="container mt-4">
                <div class="row">
                    <div class="col-md-8">
                        <h2>Search</h2>
                        <div class="input-group mb-3">
                            <select class="form-select" name="search">
                                <option>Select an option...</option>
                                <option value="YEAR" <%=(searchStr.equals("YEAR")) ? "selected" : "" %>>YEAR
                                </option>
                                <option value="CAR_NAME" <%=(searchStr.equals("CAR_NAME")) ? "selected" : "" %>
                                    >CAR_NAME</option>
                            </select>
                            <input type="text" name="words" value='<%= params.getOrDefault("words", "") %>'
                                class="form-control" placeholder="Search..." id="keydownEnter">
                            <button class="btn btn-primary" type="submit" formaction="/carInfor/map/selectSearch"
                                formmethod="get">Go</button>
                        </div>
                        <h2>Table</h2>
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>Year</th>
                                    <th>Car Name</th>
                                    <th>ID</th>
                                    <th>Manufacturer ID</th>
                                    <th>Delete</th>
                                </tr>
                            </thead>
                            <tbody id="carTableBody">
                                <% ArrayList resultList=(ArrayList)result.get("resultList"); 
                                    for(int i=0; i < resultList.size(); i=i+1){
                                        HashMap record=(HashMap)resultList.get(i); %>
                                    <tr>
                                        <td>
                                            <%= record.get("CAR_NAME") %>
                                        </td>
                                        <td>
                                            <%= record.get("YEAR") %>
                                        </td>
                                        <td>
                                            <%= record.get("CAR_INFOR_ID") %>
                                        </td>
                                        <td>
                                            <%= record.get("COMPANY_ID") %>
                                        </td>
                                        <td>
                                            <button formaction='/carInfor/map/deleteAndSelectSearch/<%= record.get("CAR_INFOR_ID") %>' formmethod="post">Del</button>
                                        </td>
                                    </tr>
                                    <% } %>
                                        <!-- Empty -->
                            </tbody>
                        </table>

                        <%
                        Paginations paginations = (Paginations)result.get("paginations"); 
                        %>
                        <div>총 갯수 : <%= paginations.getTotalCount() %></div>
                        <nav aria-label="Page navigation">
                            <ul class="pagination">
                                <li class="page-item"><a class="page-link" href="#">Previous</a></li>

                                <%
                                for(int i=paginations.getBlockStart();i <= paginations.getBlockEnd(); i=i+1){
                                %>
                                <li class="page-item">
                                    <a class="page-link" href="/carInfor/map/selectSearch?currentPage=<%= i %>"><%= i %></a>
                                </li>
                                <%
                                }
                                %>
                                <!--li class="page-item">
                                    <a class="page-link" href="/carInfor/map/selectSearch?currentPage=1">1</a>
                                </li>
                                <li class="page-item">
                                    <a class="page-link" href="/carInfor/map/selectSearch?currentPage=2">2</a>
                                </li>
                                <li class="page-item">
                                    <a class="page-link" href="/carInfor/map/selectSearch?currentPage=3">3</a>
                                </li-->

                                <li class="page-item">
                                    <a class="page-link" href="/carInfor/map/selectSearch?currentPage=<%= paginations.getNextPage() %>">Next</a>
                                </li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </form>


        <!-- Footer -->
        <%@ include file="/WEB-INF/views/commons/footer.jsp" %>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>