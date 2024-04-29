<%-- 
    Document   : produto
    Created on : 15/04/2024, 14:54:33
    Author     : Senai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <link rel="stylesheet" href="./styles/produtos.css" />


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
                <a href="./Produtos?idUsuario=${usuario.idUsuario}">
                    <h1>FanFut Store</h1>
                </a>    
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
                <form class="d-flex" role="search">
                    <input class="form-control me-2" type="search" placeholder="O que você procura?" aria-label="Search">
                    <button class="btn btn-outline-success" type="submit"><i id="search-icon"
                                                                             class="fa-solid fa-magnifying-glass"></i></button>
                </form>
            </div>

            <div class="icons">
                <div class="dropdown">
                    <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown"
                            aria-expanded="false">
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

        <main>
            <form method="post" action="adicionar" name="frmAdicionar" class="container">
                <div class="imagem-left">
                    <img src="data:image/jpeg;base64,${produto.imagemBase64}" alt="${produto.nome}">
                </div>
                <div class="descricao-right">
                    <div class="nome">
                        <span id="stars">
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                        </span>
                        <p>${produto.nome}</p>
                    </div>
                    <div class="valor">
                        <p>Preço</p>
                        <p>R$ <span>${produto.valorFinal}</span> <s> R$ ${produto.valor}</s></p>
                    </div>
                    <div class="comprar">         
                        <div class="listaTamanho">
                            <ul class="list-group">
                                <li class="list-group-item">
                                    <input class="form-check-input me-1" type="radio" name="listGroupRadio" value="P" id="firstRadio" checked>
                                    <label class="form-check-label" for="firstRadio">P</label>
                                </li>
                                <li class="list-group-item">
                                    <input class="form-check-input me-1" type="radio" name="listGroupRadio" value="M" id="secondRadio">
                                    <label class="form-check-label" for="secondRadio">M</label>
                                </li>
                                <li class="list-group-item">
                                    <input class="form-check-input me-1" type="radio" name="listGroupRadio" value="G" id="thirdRadio">
                                    <label class="form-check-label" for="thirdRadio">G</label>
                                </li>
                            </ul>
                            <!-- Adicione um campo oculto para o ID do usuário -->
                            <input type="hidden" name="idUsuario" value="${usuario.idUsuario}">
                            <!-- Adicione um atributo "name" ao botão para que ele seja enviado no formulário -->
                            <button id="btn" type="submit" class="btn btn-success" name="btnComprar">Comprar</button>
                        </div>
                        <span id="duvidas">Dúvidas sobre este produto? Código do produto: #${produto.idProduto}</span>
                    </div>
                </div>
            </form>
        </main>


    </main>
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