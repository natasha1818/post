import kotlin.text.Typography.copyright
data class Post(
    val id: Int,            //Идентификатор записи.
    val ownerId: Int,        //Идентификатор владельца стены, на которой размещена запись
    val fromId: Int,        //Идентификатор автора записи (от чьего имени опубликована запись)
    val date: String,        //Время публикации записи в формате
    val text: String,      //Текст записи.
    val friendsOnly: Boolean = false,    //если запись была создана с опцией «Только для друзей»
    val canPin: Boolean,    //Информация о том, может ли текущий пользователь закрепить запись
    val canDelete: Boolean, //Информация о том, может ли текущий пользователь удалить запись
    val canEdit: Boolean, //Информация о том, может ли текущий пользователь редактировать запись
    val isFavorite: Boolean = true, //true, если объект добавлен в закладки у текущего пользователя.
    val copyright : Copyright  //источник текста
) {}

data class Copyright (
    val idSource: Int,
    val linkSource: String,
    val nameSource: String,
    val typeSource: String)


object WallService {
    var posts = emptyArray<Post>()
    fun add(post: Post): Post {
        posts += post
        return posts.last()
    }

    fun printPost() {
        for ((index, post) in posts.withIndex()) {
            println(
                """
      № ${post.id}
      номер стены ${post.ownerId}, автор записи ${post.fromId}
      дата записи: ${post.date}
     "${post.text}"
      только для друзей:${post.friendsOnly}
      закрепить:${post.canPin}, удалить: ${post.canDelete}, редактировать: ${post.canEdit}
      добавить в закладку: ${post.isFavorite}
      источник: [${post.copyright.idSource},${post.copyright.linkSource},
      ${post.copyright.nameSource}, ${post.copyright.typeSource}]
      
                """.trimIndent()
            )
        }
    }
}

fun main() {
    val post = Post(
        112,
        6565,
        6565,
        "01/02/2023",
        "Домашняя кошка - социальное животное, обладающее развитым интеллектом и способностями к общению, умеющее испытывать и выражать сложные чувства и эмоции.",
        friendsOnly = true,
        false,
        false,
        false,
        copyright = Copyright(12,
            "https://naturae.ru/zhivotnyi-mir/mlekopitayushhie/koshki.html",
            "author",
            "active")
    )

    val post2 = Post(
        113,
        6565,
        6565,
        "01/02/2023",
        "Размеры тела котов и кошек, в среднем, составляют около 30-60 см в длину и 20-30 см в высоту",
        false,
        false,
        false,
        false,
        copyright = Copyright(23,
            "https://naturae.ru/zhivotnyi-mir/mlekopitayushhie/koshki.html",
            "author",
            "active")
    )
    val post3 = Post(
        114,
        6565,
        6565,
        "01/02/2023",
        "Кошки являются плотоядными животными, представляя собой мелких хищников. ",
        false,
        false,
        false,
        false,
        copyright = Copyright(215,
            "https://naturae.ru/zhivotnyi-mir/mlekopitayushhie/koshki.html",
            "author",
            "active")
    )
    WallService.add(post)
    WallService.add(post2)
    WallService.add(post3)
    WallService.printPost()

}






