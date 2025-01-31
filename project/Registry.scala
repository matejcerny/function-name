import sbt.*

object Registry {

  val github: Credentials = sys.env
    .get("GITHUB_TOKEN")
    .map(Credentials("GitHub Package Registry", "maven.pkg.github.com", "matejcerny", _))
    .getOrElse(Credentials(Path.userHome / ".sbt" / ".github_credentials"))

  val credentials: Seq[Credentials] = Seq(github)

  val publishToGithub: Option[MavenRepository] =
    Some("GitHub Package Registry" at s"https://maven.pkg.github.com/matejcerny/function-name")
}
