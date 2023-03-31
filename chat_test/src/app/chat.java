package app;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class chat
 */
@WebServlet("/chat")
public class chat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public chat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("/view/index.jsp").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1. lấy giá trị từ form

				
				String texts = req.getParameter("texts");
				String action = req.getParameter("Action");
				//2. tạo đối tượng
				User entity = new User();
				entity.setTexts(texts);
				//3. tao doi tuong dao
				chatDAO dao = new chatDAO();
				User kq = null;
				//4. gọi hàm create
				if(action.equals("insert"))
				{
					 kq = dao.create(entity);
				}
				//User kq = dao.create(entity);		
				if (kq == null)
					req.getRequestDispatcher("/view/fail.jsp").forward(req, resp);
				else
					req.getRequestDispatcher("/view/success.jsp").forward(req, resp);
				
			}

}
