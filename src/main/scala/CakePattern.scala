package cake.pattern
import scala.specs.mock._

trait UserRepoCompnent {
  val userRepo = new UserRepo
  class UserRepo {
    def authenticate(user: User){
      println("Authenticating user: " + user)
      user
    }
    def create(user: User){
      println("Creating user: " + user)
    }
    def delete(user: User){
      println("Delete user: " + user)
    }
  }
}

trait UserServiceComponent {
  this: UserRepoComponent

  val userService = new UserService
  class UserService {
    def authenticate(username: String, password: String): User {
      userRepo.authenticate(username, password)
    }
    def create(username: String, password: String) {
      userRepo.create(username, password)
    }
    def delete(user: User) {
      userRepo.delete(user)
    }
  }
}

object ComponentRegistry extends UserServiceComponent with UserRepositoryComponent {
  val userRepository = new UserRepo
  val userService = new UserService
}

trait TestingEnvironment extends UserServiceComponent with UserRepoComponent with JMocker {
  val userRepo = mock(classOf[UserRepo])
  val userService = mock(classOf[UserService])
}
