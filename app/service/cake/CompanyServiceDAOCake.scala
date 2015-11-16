package service.cake

import model.Company


/**
 * Created by nazar on 16.11.15.
 */
trait CompanyServiceDAOCake {

  def companyDAO: CompanyServiceDAO

  trait CompanyServiceDAO extends LoadCake[Company, Int]
  with DeleteCake[Company, Int]
  with UpdateCake[Company]
  with InsertCake[Company] {
    def list(): List[Company]
  }



}
