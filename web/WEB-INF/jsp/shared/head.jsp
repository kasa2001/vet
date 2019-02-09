<%@ page import="java.util.Random" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<head>

    <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
    <meta http-equiv="Pragma" content="no-cache" />
    <meta http-equiv="Expires" content="0" />
    <title>${ param['pageName'] }</title>
    <link rel="stylesheet" type="text/css"
          href="/webjars/bootstrap-material-design/4.1.1/assets/css/docs.min.css?<%=new Random().nextLong()%>" />
    <link rel="stylesheet" type="text/css"
          href="/statics/css/main.css" />

</head>