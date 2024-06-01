import DbClient.*
import cats.effect.IO
import munit.CatsEffectSuite

class IntegrationSuite extends CatsEffectSuite:

  test("pure_db_logic(123) returns 42") {
    DbClient.postgres.pureDbLogic(123).assertEquals(Some(42))
  }
