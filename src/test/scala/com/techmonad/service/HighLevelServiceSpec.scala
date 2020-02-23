package com.techmonad.service

import org.mockito.MockitoSugar
import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec


class HighLevelServiceSpec extends AnyWordSpec with MockitoSugar with Matchers {

  /**
   * LowLevelService Mocked instance
   */
  val mockedLowLevelService = mock[LowLevelService]

  /**
   * Create instance of high level service object with mocked dependencies
   */
  val highLevelService = new HighLevelService {
    /** *
     * inject mocked instance into High Level Service
     */
    override val lowLevelService: LowLevelService = mockedLowLevelService
  }
  
  "HighLevelService " should {

    "get employee list as json" in {
      when(mockedLowLevelService.getAll()) thenReturn List(Employee(1, "bob"))
      val employeeJson = highLevelService.getAllEmployeeAsJson()
      employeeJson mustBe """[{"id":1,"name":"bob"}]"""
    }

    "create employee from json" in {
      when(mockedLowLevelService.insert(Employee(1, "rob"))) thenReturn 1
      val result = highLevelService.createEmployeeFromJson("""{"id":1,"name":"rob"}""")
      result mustBe 1
    }
  }

}
