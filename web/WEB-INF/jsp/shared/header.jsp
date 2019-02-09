<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<header id="header" class="navbar navbar-expand bg-light flex-column flex-md-row">
    <div class="navbar-nav-scroll">
        <ul class="nav nav-tabs bg-light">

            <li class="nav-item">
                <a class="nav-link ${param['pageName'] eq 'home' ?'active':''}"  href="/" >Strona główna</a>
            </li>
            <li class="nav-item">
                <a class="nav-link ${param['pageName'] eq 'registry' ?'active':''}"  href="/registry">Rejestracja</a>
            </li>
            <li class="nav-item">
                <a class="nav-link ${param['pageName'] eq 'login' ?'active':''}"  href="/login">Logowanie</a>
            </li>
            <li class="nav-item">
                <a class="nav-link ${param['pageName'] eq 'visit' ?'active':''}"  href="/visit">Zarejestruj wizytę</a>
            </li>
        </ul>
    </div>
</header>


