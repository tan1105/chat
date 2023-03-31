package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


public class chatDAO {
//

	// 1. khai báo hàm
	public User create(User entity ) {

		User kq = new User();
		// 1. Nạp persistence.xml và tạo EntityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PolyOE");
		// 2. Tạo EntityManager để bắt đầu làm việc với CSDL
		EntityManager em = emf.createEntityManager();		
		try {
			em.getTransaction().begin(); // 3. Bắt đầu Transaction
			// 4. VIẾT MÃ THAO TÁC CREATE
			

			// 7. Insert vào CSDL
			em.persist(entity);
			em.getTransaction().commit(); // 8.thêm thành công..commit... Chấp nhận kết quả thao tác
			System.out.println("Thêm mới thành công!");
			kq = entity;
		} catch (Exception e) {
			// 9. nếu thêm không thành thì ...rollback..
			em.getTransaction().rollback(); // Hủy thao tác
			System.out.println("Thêm mới thất bại!");
			kq = null;
		}
		// 10. dù thành công hay không thành công nên đóng lại
		em.close();
		emf.close();
		return kq;
	}

	



	
}
