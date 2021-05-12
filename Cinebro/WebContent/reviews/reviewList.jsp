<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<!DOCTYPE html>
<html lang="zxx">
<head>
</head>
<body>
	<%-- <%@ include file="header.jsp" %> --%>
	<%-- <jsp:include page="<%=contextPath%>/anime-main/header.jsp"/> --%>
	<jsp:include page="./../anime-main/header.jsp"/>
	<section>
		<c:forEach var="bean2" items="${requestScope.reviewLists }">
			<table>
				<tr>
					<td>${bean.filmTitle }</td>
					<td>${bean.writer }</td>
					<td>${bean.content}</td>
					<td>${bean.rating}</td>
					<td>${bean.getlike}</td>
				</tr>
			</table>
		
		</c:forEach>
	</section>
	<section id="popular-reviews" class="section">

		<h2 class="section-heading -spaced">
			<a href="/reviews/popular/this/week/">Popular reviews this week</a>
		</h2>
		<a href="/reviews/popular/this/week/" class="all-link">More</a>
		
		<c:forEach var="bean" items="${requestScope.reviewLists}">
			<ul class="poster-list -p70 film-list clear film-details-list no-title">

			<li class="film-detail film-not-watched">
				<div
					class="react-component film-poster film-poster-431888 poster linked-film-poster removed-from-watchlist"
					data-component-class="globals.comps.FilmPosterComponent"
					data-film-id="431888"
					data-film-name="The Mitchells vs. The Machines"
					data-poster-url="/film/the-mitchells-vs-the-machines/image-150/"
					data-film-release-year="2021"
					data-new-list-with-film-action="/list/new/with/the-mitchells-vs-the-machines/"
					data-remove-from-watchlist-action="/film/the-mitchells-vs-the-machines/remove-from-watchlist/"
					data-add-to-watchlist-action="/film/the-mitchells-vs-the-machines/add-to-watchlist/"
					data-rate-action="/film/the-mitchells-vs-the-machines/rate/"
					data-mark-as-watched-action="/film/the-mitchells-vs-the-machines/mark-as-watched/"
					data-mark-as-not-watched-action="/film/the-mitchells-vs-the-machines/mark-as-not-watched/"
					data-film-link="/film/the-mitchells-vs-the-machines/"
					data-target-link="/schaffrillas/film/the-mitchells-vs-the-machines/"
					data-target-link-target="" data-show-menu="true"
					data-film-in-watchlist="false">
					<div>
						<img
							src="https://a.ltrbxd.com/resized/film-poster/4/3/1/8/8/8/431888-the-mitchells-vs-the-machines-0-70-0-105-crop.jpg?k=48df927dcc"
							width="70" height="105" alt="The Mitchells vs. The Machines"
							srcset="https://a.ltrbxd.com/resized/film-poster/4/3/1/8/8/8/431888-the-mitchells-vs-the-machines-0-140-0-210-crop.jpg?k=77b609ba18 2x"
							class="image"><a
							href="/schaffrillas/film/the-mitchells-vs-the-machines/"
							class="frame has-menu"
							data-original-title="The Mitchells vs. The Machines (2021)">
							<span
							class="overlay"></span><span
							class="overlay-actions js-film-options -w70"
							style="display: none;"><span
								class="film-watch-link-target" data-film-id="431888"><span
									class="film-watch-link"><span
										class="has-icon icon-16 icon-watch ajax-click-action"
										data-action="/film/the-mitchells-vs-the-machines/mark-as-watched/"><span
											class="replace icon"></span>Seen this film?</span></span></span><span
								class="like-link-target" data-likeable-uid="film:431888"><span
									class="like-link"><span
										class="has-icon icon-16 ajax-click-action  icon-like"
										data-action="/s/film:431888/like/"
										data-recaptcha-action="film_like"><span class="icon"></span>Like
											this film?</span></span></span><span class="replace menu-link icon"></span></span></a>
					</div>
				</div>
				<div class="film-detail-content">
					<h2 class="headline-2 prettify">
						<a href="/schaffrillas/film/the-mitchells-vs-the-machines/">${bean.filmTitle }</a> <small class="metadata"><a
							href="/films/year/2021/">2021</a></small>
					</h2>
					<div class="attribution-block -large">
						<a class="avatar -a24" href="/schaffrillas/"
							data-original-title=""> <img
							src="https://a.ltrbxd.com/resized/avatar/twitter/1/2/0/3/7/7/7/shard/http___pbs.twimg.com_profile_images_971914645509410816_jGeTaaO7-0-48-0-48-crop.jpg?k=05e1d82e94"
							alt="James (Schaffrillas)" width="24" height="24">
						</a>
						<p class="attribution">
							<strong class="name"><a href="/schaffrillas/">${bean.writer }</a></strong> 
							<span class="rating -green rated-8"> 
								${bean.rating }
							</span> 
							<span class="content-metadata"><a
								href="/schaffrillas/film/the-mitchells-vs-the-machines/"
								class="has-icon icon-comment icon-16 comment-count"><span
									class="icon"></span>86</a></span>
						</p>
					</div>
					<div class="body-text -prose collapsible-text"
						data-full-text-url="/s/full-text/viewing:167913626/">
						<p>${bean.content }</p>
					</div>
					<p class="like-link-target react-component -monotone"
						data-component-class="globals.comps.LikeLinkComponent"
						data-likeable-uid="viewing:167913626" data-likeable-name="review"
						data-likeable="true"
						data-likes-page="/schaffrillas/film/the-mitchells-vs-the-machines/likes/"
						data-format="svg" data-owner="Schaffrillas">
						<span class="like-link"> <a href="#"
							class="svg-action -like ajax-click-action  "
							data-action="/s/viewing:167913626/like/"
							data-recaptcha-action="viewing_like">Like review</a> &nbsp; <a
							href="/schaffrillas/film/the-mitchells-vs-the-machines/likes/"
							class="count">${bean.getlike }</a>
						</span>
					</p>
				</div>
			</li>
		</ul>
	</c:forEach>
	</section>

	<jsp:include page="./../anime-main/footer.jsp"/>
</body>
</html>