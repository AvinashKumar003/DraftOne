package com.DraftOneCRUD.DraftOne.Repository;

import com.DraftOneCRUD.DraftOne.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<Users,Long> {


}
