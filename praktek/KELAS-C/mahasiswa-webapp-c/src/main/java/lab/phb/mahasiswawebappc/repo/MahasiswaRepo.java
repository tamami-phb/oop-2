package lab.phb.mahasiswawebappc.repo;

import lab.phb.mahasiswawebappc.entity.Mahasiswa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MahasiswaRepo 
		extends JpaRepository<Mahasiswa,String> {}