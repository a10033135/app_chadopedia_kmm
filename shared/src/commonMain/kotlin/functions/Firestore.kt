package functions

import model.ChadoContent
import model.MainCategory
import model.SubCategory

expect suspend fun getMainCate(): List<MainCategory>

expect suspend fun getSubCate(): List<SubCategory>

expect suspend fun getChadoContent(): List<ChadoContent>
