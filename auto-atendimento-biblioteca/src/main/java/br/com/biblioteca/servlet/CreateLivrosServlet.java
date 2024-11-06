package br.com.biblioteca.servlet;

import br.com.biblioteca.dao.LivrosDao;
import br.com.biblioteca.model.Livros;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.commons.fileupload.servlet.ServletFileUpload.isMultipartContent;

@WebServlet("/create-livro")
public class CreateLivrosServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, String> parameters = uploadImage(req);

        String titulo = parameters.get("titulo");
        String autor = parameters.get("autor");
        String quantidade = parameters.get("quantidade");
        String id = parameters.get("id");
        String isbn = parameters.get("isbn");
        String editora = parameters.get("editora");
        String anoPublicacao = parameters.get("anoPublicacao");
        String sinopse = parameters.get("sinopse");
        String categoria = parameters.get("categoria");
        String location = parameters.get("location");
        String image = parameters.get("image");

        LivrosDao livrosDao = new LivrosDao();
        Livros livro = new Livros(titulo, autor, isbn, editora, quantidade, anoPublicacao, id, sinopse, categoria, image, location);

        livrosDao.createLivro(livro);

        resp.sendRedirect("/addlivroADM.jsp");
    }

    private String processUploadFile(FileItem fileItem) throws Exception {

        // Verifique se o arquivo não está vazio
        if (fileItem.getName() != null && !fileItem.getName().isEmpty()) {
            Long currentTime = new Date().getTime();
            String fileName = currentTime.toString().concat("-").concat(fileItem.getName().replace(" ", ""));
            String filePath = this.getServletContext().getRealPath("img").concat(File.separator).concat(fileName);
            fileItem.write(new File(filePath));

            return "img/" + fileName;
        } else {
            return "img/imagenotfound.webp";
        }
    }

    private void checkFieldType(FileItem fileItem, Map requestParameters) throws Exception {

        if (fileItem.isFormField()) {

            requestParameters.put(fileItem.getFieldName(), fileItem.getString());

        } else {

            String fileName = processUploadFile(fileItem);

            requestParameters.put("image", fileName);

        }

    }

    private Map<String, String> uploadImage(HttpServletRequest httpServletRequest) {

        HashMap<String, String> parameters = new HashMap<>();

        if (isMultipartContent(httpServletRequest)) {

            try {

                DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();

                List<FileItem> fileItems = new ServletFileUpload(diskFileItemFactory).parseRequest(httpServletRequest);

                for (FileItem item : fileItems) {

                    checkFieldType(item, parameters);

                }

            } catch (Exception e) {

                parameters.put("image", "img/imagenotfound.webp");

            }

            return parameters;

        }

        return parameters;

    }

}
