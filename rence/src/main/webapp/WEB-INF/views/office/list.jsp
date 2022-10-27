<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<c:set var="path" value="${pageContext.request.contextPath}" />

<!-- 리스트 NULL일 때 -->
<div class="list-page-wrap blind">
    <section class="list-box-null-section">
        <div class="null-first-section">
            <span class="advice-txt">해당 검색어에 관한 공간이 없습니다.</span>
        </div>
        <div class="null-second-section">
            <span class="advice-txt-small">이런 공간은 어떠세요?</span>
            <input type="button" id="" class="go-all-list" value="다른 곳 보러 가기"/>
        </div>
    </section>
</div>

<!-- 리스트 NOT NULL일 때 -->
<section class="listPage-section">
    <div class="sort-wrap">
        <div class="sort">
            <span class="choice-sort-text">최신순</span>
            <img src="${path}/resources/IMG/list/dropdown.svg" alt="sort-dropdown-img" class="sort-dropdown-img" id="sort-dropdown-img"/>
        </div>
        <div class="sort-select-box-wrap blind">
            <ul class="sort-select-box">
                <li class="sort-select-list">최신순</li>
                <li class="sort-select-list">별점순</li>
                <li class="sort-select-list">가격 낮은순</li>
                <li class="sort-select-list">가격 높은순</li>
            </ul>
        </div>    
    </div>
    
    <div class="listPage-wrap">
        <div class="list-box-wrap">
            <!-- START LIST BOX -->
          <div class="list-box">
              <section>
                  <img src="${path}/resources/IMG/reserve-list/default-space.svg" alt="default-space-img" class="list-thumbnail" />
              </section>
              <section class="list-box-info">
                  <ul>
                      <li class="box-info-c-name">오라운트</li>
                      <li class="box-location-wrap">
                          <img src="${path}/resources/IMG/reserve-list/location-icon.svg" alt="location-icon" class="location-icon">
                          <span class="box-info-location">경기도 광주시</span>
                      </li>
                      <li class="box-tag-wrap">
                          <span class="box-tag">#경기광주</span>
                          <span class="box-tag">#1인데스크</span>
                          <span class="box-tag">#스터디룸</span>
                      </li>
                      <li class="box-price-rating-wrap">
                          <div class="box-room-min-price-wrap">
                              <span class="box-room-min-price">10,000</span>
                              <span class="price-unit">원/시간</span>
                          </div>
                          <div class="box-room-rating">
                              <img src="${path}/resources/IMG/common/star.svg" alt="" class="box-star" />
                              <span class="rating-num">4.12</span>
                          </div>
                      </li>
                  </ul>
              </section>
          </div>
          <!-- END LIST BOX -->
          <!-- START LIST BOX -->
          <div class="list-box">
              <section>
                  <img src="${path}/resources/IMG/reserve-list/default-space.svg" alt="default-space-img" class="list-thumbnail" />
              </section>
              <section class="list-box-info">
                  <ul>
                      <li class="box-info-c-name">오라운트</li>
                      <li class="box-location-wrap">
                          <img src="${path}/resources/IMG/reserve-list/location-icon.svg" alt="location-icon" class="location-icon">
                          <span class="box-info-location">경기도 광주시</span>
                      </li>
                      <li class="box-tag-wrap">
                          <span class="box-tag">#경기광주</span>
                          <span class="box-tag">#1인데스크</span>
                          <span class="box-tag">#스터디룸</span>
                      </li>
                      <li class="box-price-rating-wrap">
                          <div class="box-room-min-price-wrap">
                              <span class="box-room-min-price">10,000</span>
                              <span class="price-unit">원/시간</span>
                          </div>
                          <div class="box-room-rating">
                              <img src="${path}/resources/IMG/common/star.svg" alt="" class="box-star" />
                              <span class="rating-num">4.12</span>
                          </div>
                      </li>
                  </ul>
              </section>
          </div>
          <!-- END LIST BOX -->
          <!-- START LIST BOX -->
          <div class="list-box">
              <section>
                  <img src="${path}/resources/IMG/reserve-list/default-space.svg" alt="default-space-img" class="list-thumbnail" />
              </section>
              <section class="list-box-info">
                  <ul>
                      <li class="box-info-c-name">오라운트</li>
                      <li class="box-location-wrap">
                          <img src="${path}/resources/IMG/reserve-list/location-icon.svg" alt="location-icon" class="location-icon">
                          <span class="box-info-location">경기도 광주시</span>
                      </li>
                      <li class="box-tag-wrap">
                          <span class="box-tag">#경기광주</span>
                          <span class="box-tag">#1인데스크</span>
                          <span class="box-tag">#스터디룸</span>
                      </li>
                      <li class="box-price-rating-wrap">
                          <div class="box-room-min-price-wrap">
                              <span class="box-room-min-price">10,000</span>
                              <span class="price-unit">원/시간</span>
                          </div>
                          <div class="box-room-rating">
                              <img src="${path}/resources/IMG/common/star.svg" alt="" class="box-star" />
                              <span class="rating-num">4.12</span>
                          </div>
                      </li>
                  </ul>
              </section>
          </div>
          <!-- END LIST BOX -->
          <!-- START LIST BOX -->
          <div class="list-box">
              <section>
                  <img src="${path}/resources/IMG/reserve-list/default-space.svg" alt="default-space-img" class="list-thumbnail" />
              </section>
              <section class="list-box-info">
                  <ul>
                      <li class="box-info-c-name">오라운트</li>
                      <li class="box-location-wrap">
                          <img src="${path}/resources/IMG/reserve-list/location-icon.svg" alt="location-icon" class="location-icon">
                          <span class="box-info-location">경기도 광주시</span>
                      </li>
                      <li class="box-tag-wrap">
                          <span class="box-tag">#경기광주</span>
                          <span class="box-tag">#1인데스크</span>
                          <span class="box-tag">#스터디룸</span>
                      </li>
                      <li class="box-price-rating-wrap">
                          <div class="box-room-min-price-wrap">
                              <span class="box-room-min-price">10,000</span>
                              <span class="price-unit">원/시간</span>
                          </div>
                          <div class="box-room-rating">
                              <img src="${path}/resources/IMG/common/star.svg" alt="" class="box-star" />
                              <span class="rating-num">4.12</span>
                          </div>
                      </li>
                  </ul>
              </section>
          </div>
          <!-- END LIST BOX -->
          <!-- START LIST BOX -->
          <div class="list-box">
              <section>
                  <img src="${path}/resources/IMG/reserve-list/default-space.svg" alt="default-space-img" class="list-thumbnail" />
              </section>
              <section class="list-box-info">
                  <ul>
                      <li class="box-info-c-name">오라운트</li>
                      <li class="box-location-wrap">
                          <img src="${path}/resources/IMG/reserve-list/location-icon.svg" alt="location-icon" class="location-icon">
                          <span class="box-info-location">경기도 광주시</span>
                      </li>
                      <li class="box-tag-wrap">
                          <span class="box-tag">#경기광주</span>
                          <span class="box-tag">#1인데스크</span>
                          <span class="box-tag">#스터디룸</span>
                      </li>
                      <li class="box-price-rating-wrap">
                          <div class="box-room-min-price-wrap">
                              <span class="box-room-min-price">10,000</span>
                              <span class="price-unit">원/시간</span>
                          </div>
                          <div class="box-room-rating">
                              <img src="${path}/resources/IMG/common/star.svg" alt="" class="box-star" />
                              <span class="rating-num">4.12</span>
                          </div>
                      </li>
                  </ul>
              </section>
          </div>
          <!-- END LIST BOX -->
          <!-- START LIST BOX -->
          <div class="list-box">
              <section>
                  <img src="${path}/resources/IMG/reserve-list/default-space.svg" alt="default-space-img" class="list-thumbnail" />
              </section>
              <section class="list-box-info">
                  <ul>
                      <li class="box-info-c-name">오라운트</li>
                      <li class="box-location-wrap">
                          <img src="${path}/resources/IMG/reserve-list/location-icon.svg" alt="location-icon" class="location-icon">
                          <span class="box-info-location">경기도 광주시</span>
                      </li>
                      <li class="box-tag-wrap">
                          <span class="box-tag">#경기광주</span>
                          <span class="box-tag">#1인데스크</span>
                          <span class="box-tag">#스터디룸</span>
                      </li>
                      <li class="box-price-rating-wrap">
                          <div class="box-room-min-price-wrap">
                              <span class="box-room-min-price">10,000</span>
                              <span class="price-unit">원/시간</span>
                          </div>
                          <div class="box-room-rating">
                              <img src="${path}/resources/IMG/common/star.svg" alt="" class="box-star" />
                              <span class="rating-num">4.12</span>
                          </div>
                      </li>
                  </ul>
              </section>
          </div>
          <!-- END LIST BOX -->
          <!-- START LIST BOX -->
          <div class="list-box">
              <section>
                  <img src="${path}/resources/IMG/reserve-list/default-space.svg" alt="default-space-img" class="list-thumbnail" />
              </section>
              <section class="list-box-info">
                  <ul>
                      <li class="box-info-c-name">오라운트</li>
                      <li class="box-location-wrap">
                          <img src="${path}/resources/IMG/reserve-list/location-icon.svg" alt="location-icon" class="location-icon">
                          <span class="box-info-location">경기도 광주시</span>
                      </li>
                      <li class="box-tag-wrap">
                          <span class="box-tag">#경기광주</span>
                          <span class="box-tag">#1인데스크</span>
                          <span class="box-tag">#스터디룸</span>
                      </li>
                      <li class="box-price-rating-wrap">
                          <div class="box-room-min-price-wrap">
                              <span class="box-room-min-price">10,000</span>
                              <span class="price-unit">원/시간</span>
                          </div>
                          <div class="box-room-rating">
                              <img src="${path}/resources/IMG/common/star.svg" alt="" class="box-star" />
                              <span class="rating-num">4.12</span>
                          </div>
                      </li>
                  </ul>
              </section>
          </div>
          <!-- END LIST BOX -->
          <!-- START LIST BOX -->
          <div class="list-box">
              <section>
                  <img src="${path}/resources/IMG/reserve-list/default-space.svg" alt="default-space-img" class="list-thumbnail" />
              </section>
              <section class="list-box-info">
                  <ul>
                      <li class="box-info-c-name">오라운트</li>
                      <li class="box-location-wrap">
                          <img src="${path}/resources/IMG/reserve-list/location-icon.svg" alt="location-icon" class="location-icon">
                          <span class="box-info-location">경기도 광주시</span>
                      </li>
                      <li class="box-tag-wrap">
                          <span class="box-tag">#경기광주</span>
                          <span class="box-tag">#1인데스크</span>
                          <span class="box-tag">#스터디룸</span>
                      </li>
                      <li class="box-price-rating-wrap">
                          <div class="box-room-min-price-wrap">
                              <span class="box-room-min-price">10,000</span>
                              <span class="price-unit">원/시간</span>
                          </div>
                          <div class="box-room-rating">
                              <img src="${path}/resources/IMG/common/star.svg" alt="" class="box-star" />
                              <span class="rating-num">4.12</span>
                          </div>
                      </li>
                  </ul>
              </section>
          </div>
          <!-- END LIST BOX -->
          <!-- START LIST BOX -->
          <div class="list-box">
              <section>
                  <img src="${path}/resources/IMG/reserve-list/default-space.svg" alt="default-space-img" class="list-thumbnail" />
              </section>
              <section class="list-box-info">
                  <ul>
                      <li class="box-info-c-name">오라운트</li>
                      <li class="box-location-wrap">
                          <img src="${path}/resources/IMG/reserve-list/location-icon.svg" alt="location-icon" class="location-icon">
                          <span class="box-info-location">경기도 광주시</span>
                      </li>
                      <li class="box-tag-wrap">
                          <span class="box-tag">#경기광주</span>
                          <span class="box-tag">#1인데스크</span>
                          <span class="box-tag">#스터디룸</span>
                      </li>
                      <li class="box-price-rating-wrap">
                          <div class="box-room-min-price-wrap">
                              <span class="box-room-min-price">10,000</span>
                              <span class="price-unit">원/시간</span>
                          </div>
                          <div class="box-room-rating">
                              <img src="${path}/resources/IMG/common/star.svg" alt="" class="box-star" />
                              <span class="rating-num">4.12</span>
                          </div>
                      </li>
                  </ul>
              </section>
          </div>
          <!-- END LIST BOX -->
          <!-- START LIST BOX -->
          <div class="list-box">
              <section>
                  <img src="${path}/resources/IMG/reserve-list/default-space.svg" alt="default-space-img" class="list-thumbnail" />
              </section>
              <section class="list-box-info">
                  <ul>
                      <li class="box-info-c-name">오라운트</li>
                      <li class="box-location-wrap">
                          <img src="${path}/resources/IMG/reserve-list/location-icon.svg" alt="location-icon" class="location-icon">
                          <span class="box-info-location">경기도 광주시</span>
                      </li>
                      <li class="box-tag-wrap">
                          <span class="box-tag">#경기광주</span>
                          <span class="box-tag">#1인데스크</span>
                          <span class="box-tag">#스터디룸</span>
                      </li>
                      <li class="box-price-rating-wrap">
                          <div class="box-room-min-price-wrap">
                              <span class="box-room-min-price">10,000</span>
                              <span class="price-unit">원/시간</span>
                          </div>
                          <div class="box-room-rating">
                              <img src="${path}/resources/IMG/common/star.svg" alt="" class="box-star" />
                              <span class="rating-num">4.12</span>
                          </div>
                      </li>
                  </ul>
              </section>
          </div>
          <!-- END LIST BOX -->
          <!-- START LIST BOX -->
          <div class="list-box">
              <section>
                  <img src="${path}/resources/IMG/reserve-list/default-space.svg" alt="default-space-img" class="list-thumbnail" />
              </section>
              <section class="list-box-info">
                  <ul>
                      <li class="box-info-c-name">오라운트</li>
                      <li class="box-location-wrap">
                          <img src="${path}/resources/IMG/reserve-list/location-icon.svg" alt="location-icon" class="location-icon">
                          <span class="box-info-location">경기도 광주시</span>
                      </li>
                      <li class="box-tag-wrap">
                          <span class="box-tag">#경기광주</span>
                          <span class="box-tag">#1인데스크</span>
                          <span class="box-tag">#스터디룸</span>
                      </li>
                      <li class="box-price-rating-wrap">
                          <div class="box-room-min-price-wrap">
                              <span class="box-room-min-price">10,000</span>
                              <span class="price-unit">원/시간</span>
                          </div>
                          <div class="box-room-rating">
                              <img src="${path}/resources/IMG/common/star.svg" alt="" class="box-star" />
                              <span class="rating-num">4.12</span>
                          </div>
                      </li>
                  </ul>
              </section>
          </div>
          <!-- END LIST BOX -->
          <!-- START LIST BOX -->
          <div class="list-box">
              <section>
                  <img src="${path}/resources/IMG/reserve-list/default-space.svg" alt="default-space-img" class="list-thumbnail" />
              </section>
              <section class="list-box-info">
                  <ul>
                      <li class="box-info-c-name">오라운트</li>
                      <li class="box-location-wrap">
                          <img src="${path}/resources/IMG/reserve-list/location-icon.svg" alt="location-icon" class="location-icon">
                          <span class="box-info-location">경기도 광주시</span>
                      </li>
                      <li class="box-tag-wrap">
                          <span class="box-tag">#경기광주</span>
                          <span class="box-tag">#1인데스크</span>
                          <span class="box-tag">#스터디룸</span>
                      </li>
                      <li class="box-price-rating-wrap">
                          <div class="box-room-min-price-wrap">
                              <span class="box-room-min-price">10,000</span>
                              <span class="price-unit">원/시간</span>
                          </div>
                          <div class="box-room-rating">
                              <img src="${path}/resources/IMG/common/star.svg" alt="" class="box-star" />
                              <span class="rating-num">4.12</span>
                          </div>
                      </li>
                  </ul>
              </section>
          </div>
          <!-- END LIST BOX -->
          <!-- START LIST BOX -->
          <div class="list-box">
              <section>
                  <img src="${path}/resources/IMG/reserve-list/default-space.svg" alt="default-space-img" class="list-thumbnail" />
              </section>
              <section class="list-box-info">
                  <ul>
                      <li class="box-info-c-name">오라운트</li>
                      <li class="box-location-wrap">
                          <img src="${path}/resources/IMG/reserve-list/location-icon.svg" alt="location-icon" class="location-icon">
                          <span class="box-info-location">경기도 광주시</span>
                      </li>
                      <li class="box-tag-wrap">
                          <span class="box-tag">#경기광주</span>
                          <span class="box-tag">#1인데스크</span>
                          <span class="box-tag">#스터디룸</span>
                      </li>
                      <li class="box-price-rating-wrap">
                          <div class="box-room-min-price-wrap">
                              <span class="box-room-min-price">10,000</span>
                              <span class="price-unit">원/시간</span>
                          </div>
                          <div class="box-room-rating">
                              <img src="${path}/resources/IMG/common/star.svg" alt="" class="box-star" />
                              <span class="rating-num">4.12</span>
                          </div>
                      </li>
                  </ul>
              </section>
          </div>
          <!-- END LIST BOX -->
          <!-- START LIST BOX -->
          <div class="list-box">
              <section>
                  <img src="${path}/resources/IMG/reserve-list/default-space.svg" alt="default-space-img" class="list-thumbnail" />
              </section>
              <section class="list-box-info">
                  <ul>
                      <li class="box-info-c-name">오라운트</li>
                      <li class="box-location-wrap">
                          <img src="${path}/resources/IMG/reserve-list/location-icon.svg" alt="location-icon" class="location-icon">
                          <span class="box-info-location">경기도 광주시</span>
                      </li>
                      <li class="box-tag-wrap">
                          <span class="box-tag">#경기광주</span>
                          <span class="box-tag">#1인데스크</span>
                          <span class="box-tag">#스터디룸</span>
                      </li>
                      <li class="box-price-rating-wrap">
                          <div class="box-room-min-price-wrap">
                              <span class="box-room-min-price">10,000</span>
                              <span class="price-unit">원/시간</span>
                          </div>
                          <div class="box-room-rating">
                              <img src="${path}/resources/IMG/common/star.svg" alt="" class="box-star" />
                              <span class="rating-num">4.12</span>
                          </div>
                      </li>
                  </ul>
              </section>
          </div>
          <!-- END LIST BOX -->
        </div>
    </div>

</section>