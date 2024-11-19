<!DOCTYPE html>
<html data-bs-theme="light" lang="pt-br">

<head>
    <%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>biblioteca</title>
    <link rel="stylesheet" href="../assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i&amp;display=swap">
    <link rel="stylesheet" href="../assets/fonts/fontawesome-all.min.css">
    <link rel="stylesheet" href="../assets/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="../assets/fonts/fontawesome5-overrides.min.css">
</head>

<body>
    <div id="wrapper">
        <nav class="navbar align-items-start sidebar sidebar-dark accordion bg-gradient-primary p-0 navbar-dark" style="background: linear-gradient(rgb(2,72,115), #022840), rgb(2,72,115);">
            <div class="container-fluid d-flex flex-column p-0"><a class="navbar-brand d-flex justify-content-center align-items-center sidebar-brand m-0" href="#">
                    <div class="sidebar-brand-icon rotate-n-15"><i class="fas fa-book"></i></div>
                    <div class="sidebar-brand-text mx-3"><span>Biblioteca</span></div>
                </a>
                <hr class="sidebar-divider my-0">
                <ul class="navbar-nav text-light" id="accordionSidebar">
                    <li class="nav-item"><a class="nav-link" href="indexADM"><i class="fa fa-book"></i><span>Livros</span></a></li>
                    <li class="nav-item"><a class="nav-link" href="addlivroADM.jsp"><i class="far fa-edit" style="margin-right: 4px;font-size: 12px;"></i><span>Adicionar livro</span></a></li>
                    <li class="nav-item"><a class="nav-link" href="gerenciarusersADM"><i class="fas fa-user"></i><span>Gerenciar usu�rios</span></a></li>
                    <li class="nav-item"><a class="nav-link active" href="gerenciaremprestimosADM.html"><i class="far fa-calendar-alt"></i><span>Gerenciar empr�stimos</span></a></li>
                    <li class="nav-item"><a class="nav-link" href="confADM.jsp"><i class="fas fa-user-circle"></i><span>Configura��es de ADM</span></a></li>
                </ul>
            </div>
        </nav>
        <div class="d-flex flex-column" id="content-wrapper">
            <div id="content">
                <nav class="navbar navbar-expand bg-white shadow mb-4 topbar">
                    <button class="btn btn-primary" type="button" onclick="window.location.href='${pageContext.request.contextPath}/logout'" style="width: 100.7656px;background: rgb(2,72,115);border-color: rgb(2,72,115);">Sair</button>
                </nav>
                <div class="container-fluid">
                    <h3 class="text-dark mb-1">Gerenciar empr�stimos</h3>
                    <div>
                        <div class="card"></div>
                        <div class="card" style="margin-top: 10px;overflow: visible;">
                            <div class="card-header py-3">
                                <p class="text-primary m-0 fw-bold">Empr�stimos ativos</p>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive" style="overflow: visible;">
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th style="width: 300px;">Nome do livro</th>
                                                <th style="width: 300px;">Usu�rio</th>
                                                <th style="width: 100px;">Loca��o</th>
                                                <th style="width: 100px;">Devolu��o</th>
                                                <th style="width: 100px;">Situa��o</th>
                                                <th style="width: 100px;"></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>Cell 1</td>
                                                <td>a</td>
                                                <td>00/00/0000</td>
                                                <td>11/11/1111</td>
                                                <td style="width: 100px;">Em uso</td>
                                                <td><button class="btn btn-primary" type="button" style="background: rgb(2,72,115);border-color: rgb(2,72,115);">Devolver</button></td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                        <div class="card" style="margin-top: 10px;overflow: visible;">
                            <div class="card-header py-3">
                                <p class="text-primary m-0 fw-bold">Hist�rico</p>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive" style="overflow: visible;">
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th style="width: 300px;">Nome do livro</th>
                                                <th style="width: 300px;">Usu�rio</th>
                                                <th style="width: 100px;">Loca��o</th>
                                                <th style="width: 100px;">Devolu��o</th>
                                                <th style="width: 100px;">Situa��o</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>Cell 1</td>
                                                <td>a</td>
                                                <td>00/00/0000</td>
                                                <td>11/11/1111</td>
                                                <td style="width: 100px;">Devolvido</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <footer class="bg-white sticky-footer">
                <div class="container my-auto">
                    <div class="text-center my-auto copyright"><span>Biblioteca</span></div>
                </div>
            </footer>
        </div><a class="border rounded d-inline scroll-to-top" href="#page-top"><i class="fas fa-angle-up"></i></a>
    </div>
    <div class="modal fade" role="dialog" tabindex="-1" id="modal-1">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">Confirmar devolu��o</h4><button class="btn-close" type="button" aria-label="Close" data-bs-dismiss="modal"></button>
                </div>
                <div class="modal-body">
                    <p>Deseja confirmar a devolu��o desse livro?</p>
                </div>
                <div class="modal-footer"><button class="btn btn-light" type="button" data-bs-dismiss="modal">Fechar</button><button class="btn btn-primary" type="button" style="background: rgb(2,72,115);border-color: rgb(2,72,115);">Sim</button></div>
            </div>
        </div>
    </div>
    <script src="../assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="../assets/js/theme.js"></script>
</body>

</html>