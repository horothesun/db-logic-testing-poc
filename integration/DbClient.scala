import cats.effect.IO
import doobie.*
import doobie.implicits.*

trait DbClient:
  def pureDbLogic(a: Int): IO[Option[Int]]

object DbClient:

  def postgres: DbClient = (a: Int) =>
    val xa = Transactor.fromDriverManager[IO](
      driver = "org.postgresql.Driver",
      url = "jdbc:postgresql://localhost:5432/test_db",
      user = "postgres",
      password = "test_pwd",
      logHandler = None
    )
    sql"SELECT pure_db_logic($a)".query[Int].option.transact(xa)
