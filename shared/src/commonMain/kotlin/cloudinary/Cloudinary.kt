package cloudinary

object Cloudinary {
    private const val BASE_URL = "https://res.cloudinary.com/di0d7y9qa/image/upload/"
    private const val BASE_MAIN_CATEGORY = "main_category/"
    private const val BASE_SUB_CATEGORY = "sub_category/"
    private const val BASE_CHADO_CONTENT = "chado_content/"

    const val URL_MAIN_CATEGORY = "$BASE_URL$BASE_MAIN_CATEGORY"
    const val URL_SUB_CATEGORY = "$BASE_URL$BASE_SUB_CATEGORY"
    const val URL_CHADO_CONTENT = "$BASE_URL$BASE_CHADO_CONTENT"

}