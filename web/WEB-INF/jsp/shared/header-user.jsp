<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<header id="header" class="navbar navbar-expand bg-light flex-column flex-md-row">
    <div class="navbar-nav-scroll">
        <ul class="nav nav-tabs bg-light">
            <li class="nav-item">
                <a class="nav-link ${param['pageName'] eq 'home' ?'active':''}"  href="/" >Strona główna</a>
            </li>
            <li class="nav-item">
                <a class="nav-link ${param['pageName'] eq 'panel' ?'active':''}"  href="/user" >Panel użytkownika</a>
            </li>
            <li class="nav-item">
                <a class="nav-link ${param['pageName'] eq 'animal' ?'active':''}"  href="/user/animal" >Zobacz zwierzaki</a>
            </li>
            <li class="nav-item">
                <a class="nav-link ${param['pageName'] eq 'add' ?'active':''}"  href="/user/animal/add">Dodaj zwierzaka</a>
            </li>
            <li class="nav-item">
                <a class="nav-link ${param['pageName'] eq 'visit' ?'active':''}"  href="/user/visits">Zobacz planowane wizyty</a>
            </li>
            <li class="nav-item">
                <a class="nav-link ${param['pageName'] eq 'visit-add' ?'active':''}"  href="/user/visit/add">Dodaj wizytę</a>
            </li>
            <li class="nav-item">
                <a class="nav-link"  href="/logout">Wyloguj się</a>
            </li>
        </ul>
    </div>
</header>


