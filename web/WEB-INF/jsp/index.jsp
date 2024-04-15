<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>

<html lang="pt-br">

    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous" />

        <link rel="stylesheet" type="text/css" href="//assets.locaweb.com.br/locastyle/edge/stylesheets/locastyle.css">


        <link rel="stylesheet" href="./styles/index.css">
        <link rel="stylesheet" href="./styles/header.css" />



        <script src="https://kit.fontawesome.com/0ba8cb147b.js" crossorigin="anonymous"></script>

        <title>Pagina Inicial</title>
    </head>

    <body>
        <div class="promocao">
            <h3>
                UTILIZE O CUPOM: <b>BEMVINDO10</b> E GANHE 10% NA SUA PRIMEIRA COMPRA
                <span>(EXCETO PRODUTOS PROMOCIONAIS)</span>
            </h3>
        </div>
    <header>
        <div class="logo">
            <h1>FanFut Store</h1>
        </div>

        <div class="carrinho">

            <div class="ls-cart">
                <input type="checkbox" class="ls-checkbox-cart">
                <header class="ls-cart-header">
                    <strong id="qtd"><i class="fa-solid fa-cart-shopping"></i></strong>
                </header>
                <div class="ls-cart-content">
                    <ul class="ls-no-list-style">
                        <li>
                            <h2 class="ls-title-product">
                                <strong>01</strong> Email Marketing Locaweb
                            </h2>
                            <p> (Identificador) </p>
                            <a href="">Excluir</a>
                        </li>
                        <li>
                            <h2 class="ls-title-product">
                                <strong>02</strong> Monitor LED 27"
                            </h2>
                            <p> (Identificador) </p>
                            <a href="">Excluir</a>
                        </li>
                        <li>
                            <h2 class="ls-title-product">
                                <strong>06</strong> Honda FIT 2010 4p Flex 1.4 16v
                            </h2>
                            <p> (Identificador) </p>
                            <a href="">Excluir</a>
                        </li>
                        <li>
                            <h2 class="ls-title-product">
                                <strong>01</strong> Lorem Ipsum is simply dummy text
                            </h2>
                            <p> (Identificador) </p>
                            <a href="">Excluir</a>
                        </li>
                    </ul>
                    <footer class="ls-cart-footer ls-txt-center">
                        <a href="" class="ls-btn-primary">Finalizar Compra</a>
                    </footer>
                </div>
            </div>

        </div>
        <div class="search">
            <form  class="d-flex" role="search">
                <input class="form-control me-2" type="search" placeholder="O que você procura?" aria-label="Search">
                <button class="btn btn-outline-success" type="submit"><i id="search-icon"
                                                                         class="fa-solid fa-magnifying-glass"></i></button>
            </form>
        </div>

        <div class="icons">
            <div class="dropdown">
                <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                    <i class="fa-solid fa-user"></i>
                </button>
                <ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="./Login">Login</a></li>
                    <li><a class="dropdown-item" href="./cadastro-usuario">Cadastre-se</a></li>
                    <li><a class="dropdown-item" href="./meus-pedidos">Meus Pedidos</a></li>


                </ul>
            </div>



        </div>
    </header>

    <div class="container-baixo">
        <div class="menu">
            <div class="dropdown">
                <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                    LOJA
                </button>
                <ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="#">Action</a></li>
                    <li><a class="dropdown-item" href="#">Another action</a></li>
                    <li><a class="dropdown-item" href="#">Something else here</a></li>
                </ul>
            </div>
            <div class="dropdown">
                <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                    BRASILEIROS
                </button>
                <ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="#">Action</a></li>
                    <li><a class="dropdown-item" href="#">Another action</a></li>
                    <li><a class="dropdown-item" href="#">Something else here</a></li>
                </ul>
            </div>
            <div class="dropdown">
                <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                    INTERNACIONAIS
                </button>
                <ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="#">Action</a></li>
                    <li><a class="dropdown-item" href="#">Another action</a></li>
                    <li><a class="dropdown-item" href="#">Something else here</a></li>
                </ul>
            </div>
            <div class="dropdown">
                <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                    SELEÇÕES
                </button>
                <ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="#">Action</a></li>
                    <li><a class="dropdown-item" href="#">Another action</a></li>
                    <li><a class="dropdown-item" href="#">Something else here</a></li>
                </ul>
            </div>
            <div class="dropdown">
                <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                    FUTEBOL
                </button>
                <ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="#">Action</a></li>
                    <li><a class="dropdown-item" href="#">Another action</a></li>
                    <li><a class="dropdown-item" href="#">Something else here</a></li>
                </ul>
            </div>
            <div class="dropdown">
                <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                    CASUAL
                </button>
                <ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="#">Action</a></li>
                    <li><a class="dropdown-item" href="#">Another action</a></li>
                    <li><a class="dropdown-item" href="#">Something else here</a></li>
                </ul>
            </div>
        </div>
    </div>

    <main>
        <div id="container-carrosel">
            <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img class="d-block w-100"
                             src="./assets/Captura de tela 2024-04-08 003833.png"
                             alt="First slide">
                    </div>
                    <div class="carousel-item">
                        <img class="d-block w-100"
                             src="./assets/Captura de tela 2024-04-08 003839.png"
                             alt="Second slide">
                    </div>
                    <div class="carousel-item">
                        <img class="d-block w-100"
                             src="./assets/Captura de tela 2024-04-08 003844.png"
                             alt="Third slide">
                    </div>
                </div>
                <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </div>

        <div class="info">
            <p><i id="wallet" class="fa-solid fa-wallet"></i> <span id="txt">Parcelamos em até 10x</span></p>
        </div>
    </main>

    <section>
        <div class="cards">
            
            <c:forEach items="${produtos}" var="produto">
                <a href="./produto-item">
                    <div class="card" style="width: 18rem;">
                    <img src="./assets/Captura de tela 2024-04-08 004959.png" class="card-img-top" alt="...">
                    <div class="card-body">
                        <p class="card-text">${produto.nome}</p>
                        <span class="label-card">
                            R$ ${produto.valorFinal} <s>R$ ${produto.valor}</s>
                            <p>em até 12x de 18,23</p>
                        </span>
                    </div>
                </div>
                </a>
                

            </c:forEach>


        </div>
    </section>

    <script src="//assets.locaweb.com.br/locastyle/edge/javascripts/locastyle.js"></script>


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
    crossorigin="anonymous"></script>

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
    crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
    crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
    crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
            integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
    crossorigin="anonymous"></script>
</body>

</html>