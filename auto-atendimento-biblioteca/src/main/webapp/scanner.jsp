<!DOCTYPE html>
<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<html data-bs-theme="light" lang="pt-br">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Scanner</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i&amp;display=swap">
    <link rel="stylesheet" href="assets/fonts/fontawesome-all.min.css">
    <style>
        .toast-center {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            z-index: 1055;
        }
    </style>
</head>

<body class="bg-gradient-primary" style="background: rgb(2,72,115);">

<!-- Toast Container -->
<div class="toast-container position-fixed bottom-0 end-0 p-3 toast-center">
    <div id="errorToast" class="toast bg-danger text-white" role="alert" aria-live="assertive" aria-atomic="true">
        <div class="toast-header">
            <strong class="me-auto">Erro</strong>
            <button type="button" class="btn-close btn-close-white" data-bs-dismiss="toast" aria-label="Close"></button>
        </div>
        <div class="toast-body">
            Livro não encontrado!
        </div>
    </div>
</div>

<div class="toast-container position-fixed bottom-0 end-0 p-3 toast-center">
    <div id="successToast" class="toast bg-success text-white" role="alert" aria-live="assertive" aria-atomic="true">
        <div class="toast-header">
            <strong class="me-auto">Sucesso</strong>
            <button type="button" class="btn-close btn-close-white" data-bs-dismiss="toast" aria-label="Close"></button>
        </div>
        <div class="toast-body">
            Empréstimo gerado com sucesso!
        </div>
    </div>
</div>


<div class="container">
    <div class="card shadow-lg o-hidden border-0 my-5">
        <div class="card-body p-0">
            <div class="row" style="height: 590.781px;">
                <div class="col-lg-5 d-none d-lg-flex">
                    <div class="flex-grow-1 bg-register-image" style="background: url(assets/img/dogs/barcode-scan.gif) center / contain no-repeat, #ffffff;"></div>
                </div>
                <div class="col-lg-7">
                    <div class="p-5"><input type="hidden">
                        <div class="text-center" style="margin-bottom: 30px;">
                            <h4 class="text-dark mb-4">Escaneie o código de barras do livro</h4>
                            <div class="row">
                                <div class="col-xxl-12">
                                    <div class="card">
                                        <div class="card-body">
                                            <h4 class="card-title">Titulo</h4><img width="200" height="300" style="height: 300px;width: 300px;" src="assets/img/Question_book-new%20(1).svg">
                                            <form action="/scanner" method="post" id="scannerForm"><input type="hidden" id="codigo" name="codigo"></form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div style="text-align: center;"><a href="index"><i class="far fa-arrow-alt-circle-left" style="font-size: 43px;color: rgb(2,72,115);" href="index"></i></a></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<script src="assets/js/theme.js"></script>

<script>
    document.addEventListener("DOMContentLoaded", function () {
        const codigoInput = document.getElementById("codigo");
        const form = document.getElementById("scannerForm");

        // Mantém o foco no documento para o scanner
        document.body.addEventListener("keydown", function (event) {
            // Preenche o input escondido com o valor capturado pelo scanner
            if (!codigoInput.value) {
                codigoInput.value = "";
            }

            // Captura a tecla digitada e adiciona ao input
            if (event.key === "Enter") {
                // Envia o formulário automaticamente após escanear
                form.submit();
            } else {
                codigoInput.value += event.key;
            }
        });
    });
</script>

<script>
    document.addEventListener("DOMContentLoaded", function () {
        const params = new URLSearchParams(window.location.search);
        if (params.has('error') && params.get('error') === 'notfound') {
            const toast = new bootstrap.Toast(document.getElementById('errorToast'));
            toast.show();
        }

        if (params.has('success') && params.get('success') === 'true') {
            const successToast = new bootstrap.Toast(document.getElementById('successToast'));
            successToast.show();
        }
    });
</script>

</body>

</html>