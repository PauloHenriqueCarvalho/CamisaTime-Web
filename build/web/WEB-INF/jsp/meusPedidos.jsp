<%-- 
    Document   : meusPedidos
    Created on : 14/04/2024, 19:32:51
    Author     : paulo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous" />
    <script src="https://kit.fontawesome.com/0ba8cb147b.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="./styles/header.css">
    <link rel="stylesheet" href="./styles/meusPedidos.css">
    <title>Meus Pedidos</title>
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
              <li><a class="dropdown-item" href="./Produtos">Inicio</a></li>
            </ul>
          </div>
         
    
          <i class="fa-solid fa-bag-shopping"></i>
        </div>
      </header>

      <main>
            <div class="pedidos">
                Voce nao tem pedidos
            </div>
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