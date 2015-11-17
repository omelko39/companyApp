package service

/**
 * Created by nazar on 16.11.15.
 */

package object cake {

  trait LoadCake[Result, PK] {

    def loadByPK(id: Int): Result

    def loadByPKs(ids: Traversable[Int]): List[Result]
  }



  trait DeleteCake[T, PK] {

    def deleteByPK(id: PK): Boolean

    def deleteByPKs(ids: Traversable[PK]): Traversable[PK]
  }

  trait UpdateCake[T] {

    def updateByObject(obj: T): Boolean

    def updateByObjects(objs: Traversable[T]): Traversable[T]
  }

  trait InsertCake[T]{

    def insertByObject(obj: T, parentId: Option[Int]): Option[T]

    def insertByObjects(objs: Traversable[T]): Traversable[T]
  }


}
