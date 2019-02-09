<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<header id="header" class="navbar navbar-expand bg-light flex-column flex-md-row">
    <div class="navbar-nav-scroll">
        <ul class="nav nav-tabs bg-light">
            <li class="nav-item">
                <a class="nav-link ${param['pageName'] eq 'home' ?'active':''}"  href="/" >Strona główna</a>
            </li>
            <li class="nav-item">
                <a class="nav-link ${param['pageName'] eq 'panel' ?'active':''}"  href="/admin" >Panel administracyjny</a>
            </li>
            <li class="nav-item">
                <a class="nav-link ${param['pageName'] eq 'add' ?'active':''}"  href="/admin/animal/add">Dodaj typ zwierzaka</a>
            </li>
            <li class="nav-item">
                <a class="nav-link ${param['pageName'] eq 'visit' ?'active':''}"  href="/admin/visit">Zobacz planowane wizyty</a>
            </li>
            <li class="nav-item">
                <a class="nav-link"  href="/logout">Wyloguj się</a>
            </li>
        </ul>
    </div>
</header>


